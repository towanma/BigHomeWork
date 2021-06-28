<template>
  <div class="gch">

    <el-row :gutter="0">
      <el-col :span="4">
        <div class="grid-content bg-purple"></div>
      </el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple"></div>
        <el-row>
          <el-col>
            <div style="background-color: rgb(240,246,253);border-radius: 4px">
              <el-row :gutter="20">
                <el-col :span="19">
                  <div class="grid-content">
                    <h2>教育部全国高校名单（截止2020-06-30）</h2>
                  </div>
                </el-col>
                <el-col :span="5">
                  <div class="grid-content">
                    <div id="nav">
                      <router-link to="/gch">按高校查询</router-link>|
                      <router-link to="/sch">按地区查询</router-link>
                    </div>
                  </div>
                </el-col>
              </el-row>
            </div>
          </el-col>
        </el-row>

        <el-container style="border-radius: 4px; border: 1px solid #eee">
          <el-aside width="200px" style="background-color: rgb(238, 241, 246);">

            //搜索菜单

            <el-autocomplete
                v-model="state"
                :fetch-suggestions="querySearchAsync"
                :trigger-on-focus="false"
                @select="handleSelect"
                placeholder="请输入内容"
            ></el-autocomplete>

          </el-aside>
          <el-container>
            <el-main>
              <el-row>
                <el-col>
                  <div style="background-color: rgb(240,246,253);border-radius: 4px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">
                    <el-row :gutter="20" class="tital">
                      <h1>{{ tiname }}</h1>
                    </el-row>
                  </div>
                </el-col>
              </el-row>
              <el-table v-loading="loading" :data="tableData" border stripe>
                <el-table-column label="序号" align="center" width="49">
                  <template slot-scope="scope">
                    {{ scope.$index + 1 }}
                  </template>
                </el-table-column>
                <el-table-column prop="code" label="学校标识码" align="center" width="100"></el-table-column>
                <el-table-column prop="schoolname" label="学校名称" align="center" width="280">
                  <template slot-scope="scope">
                    <a :href="scope.row.link" target="_blank" class="buttonText">{{ scope.row.schoolname }}</a>
                  </template></el-table-column>
                <el-table-column prop="province" label="所在地区" align="center" width="63"></el-table-column>
                <el-table-column prop="city" label="所在城市" align="center" width="63"></el-table-column>
                <el-table-column prop="department" label="主管部门" align="center" width="193"></el-table-column>
                <el-table-column prop="level" label="办学层次" align="center" width="63"></el-table-column>
                <el-table-column prop="type" label="高校类型" align="center"></el-table-column>
              </el-table>
              <el-row>
                <el-col :span="24"><div class="grid-content"></div></el-col>
              </el-row>
              <el-row>
                <el-col :span="10"><div class="grid-content"></div></el-col>
                <el-col :span="12"><div class="grid-content">
                  <el-pagination
                      background
                      :page-size="20"
                      :pager-count="11"
                      layout="prev, pager, next"
                      :total="1000">
                  </el-pagination>
                </div></el-col>
              </el-row>
              <el-container>

              </el-container>


            </el-main>

          </el-container>
        </el-container>
      </el-col>

      <el-col :span="4">
        <div class="grid-content"></div>
      </el-col>

    </el-row>

  </div>

</template>

<script>

// @ is an alias to /src
export default {

  directives: {
    clickDown: {
      inserted(el) {
        el.click()
      }
    },
  },

  data() {
    return {
      tableData: [],
      tiname:'',

      restaurants: [],
      state: '',
      timeout:  null

    }
  },

  created() {
    this.postSchooldata("type","985")
  },
  methods: {
    postSchooldata(key, value,tname) {
      this.tiname = value
      let formData = new FormData
      formData.append("key", key)
      formData.append("value", value)
      this.$axios.post("http://10.203.87.121:8081/api/pschool", formData).then(res => {
        this.tableData = res.data
      })
    },
    // editHandle() { mock测试端口
    //   this.$axios.get("/click").then(res => {
    //     this.tableData = res.data
    //   })
    // },



    querySearchAsync(queryString,callback) {
      // var restaurants = this.restaurants;
      // var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants;
      // clearTimeout(this.timeout);
      // this.timeout = setTimeout(() => {
      //   cb(results);
      // }, 3000 * Math.random());

      var list =[{}];
      let formData = new FormData
      formData.append("value", queryString)
      this.$axios.post( "http://10.203.87.121:8081/api/pgch", formData ).then(res=>{
        //在这里为这个数组中每一个对象加一个value字段, 因为autocomplete只识别value字段并在下拉列中显示
        for(let i of res.data){
          i.value = i.schoolname;  //将想要展示的数据作为value
        }
        list = res.data;
        callback(list);
      }).catch((error)=>{
        console.log(error);
      });



    },
    // createStateFilter(queryString) {
    //   return (state) => {
    //     return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
    //   };
    // },
    handleSelect(item) {
      console.log(item);
    }
  },
  // mounted() {
  //   this.restaurants = this.loadAll();
  // }
};
</script>

<style>
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
body {
  margin: 0;
}

</style>
