<template>
  <div class="sch">

    <el-row :gutter="0">
      <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="16"><div class="grid-content bg-purple"></div>
        <!--    <el-container style="; border: 1px solid #eee">-->
        <!--    <el-header style="text-align: right; font-size: 15px">-->
        <!--      <el-tabs v-model="activeName" @tab-click="handleClick">-->

        <!--        <div id="nav">-->
        <!--          <router-link to="/sch">按高校查询</router-link>-->
        <!--          |-->
        <!--          <router-link to="/neo4j">按地区查询</router-link>-->


        <!--        </div>-->
        <!--      </el-tabs>-->

        <!--    </el-header>-->
        <!--    </el-container>-->
        <el-row>
          <el-col ><div style="background-color: rgb(240,246,253);border-radius: 4px">

            <el-row :gutter="20">
              <el-col :span="19"><div class="grid-content">

                <h2>教育部全国高校名单（截止2020-06-30）</h2>
              </div></el-col>
              <el-col :span="5"><div class="grid-content">
                <div id="nav">
                  <router-link to="/about">按高校查询</router-link>
                  |
                  <router-link to="/sch">按地区查询</router-link>
                </div>

              </div></el-col>
            </el-row>

          </div>

          </el-col>
        </el-row>


        <el-container  style="border-radius: 4px; border: 1px solid #eee">
          <el-aside width="200px" style="background-color: rgb(238, 241, 246);">
            <el-menu :default-openeds="['1','2']">
              <el-submenu index="1">
                <template slot="title"><i class="el-icon-plus"></i>高校类型</template>
                <el-menu-item class="clickDown" index ="1-1" @click.native="getMenuTree('type','一流大学')" v-click-down>一流大学</el-menu-item>
                <el-menu-item index="1-2" @click.native="getMenuTree('type','一流学科')">一流学科</el-menu-item>
                <el-menu-item index="1-3" @click.native="getMenuTree('type','985')">985高校</el-menu-item>
                <el-menu-item index="1-4" @click.native="getMenuTree('type','211')">211高校</el-menu-item>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title"><i class="el-icon-plus" ></i>所在地区</template>
                <el-menu-item index="2-1" @click.native="getMenuTree('province','北京市')">北京市</el-menu-item>
                <el-menu-item index="2-2" @click.native="getMenuTree('province','四川省')">四川省</el-menu-item>
                <el-menu-item index="2-3" @click.native="getMenuTree('province','天津市')">天津市</el-menu-item>
                <el-menu-item index="2-4" @click.native="getMenuTree('province','河北省')">河北省</el-menu-item>
                <el-menu-item index="2-5" @click.native="getMenuTree('province','山西省')">山西省</el-menu-item>
                <el-menu-item index="2-6" @click.native="getMenuTree('province','内蒙古自治区')">内蒙古自治区</el-menu-item>
                <el-menu-item index="2-7" @click.native="getMenuTree('province','辽宁省')">辽宁省</el-menu-item>
                <el-menu-item index="2-8" @click.native="getMenuTree('province','吉林省')">吉林省</el-menu-item>
                <el-menu-item index="2-9" @click.native="getMenuTree('province','黑龙江省')">黑龙江省</el-menu-item>
                <el-menu-item index="2-10" @click.native="getMenuTree('province','上海市')">上海市</el-menu-item>
                <el-menu-item index="2-11" @click.native="getMenuTree('province','江苏省')">江苏省</el-menu-item>
                <el-menu-item index="2-12" @click.native="getMenuTree('province','浙江省')">浙江省</el-menu-item>
                <el-menu-item index="2-13" @click.native="getMenuTree('province','安徽省')">安徽省</el-menu-item>
                <el-menu-item index="2-14" @click.native="getMenuTree('province','福建省')">福建省</el-menu-item>
                <el-menu-item index="2-15" @click.native="getMenuTree('province','江西省')">江西省</el-menu-item>
                <el-menu-item index="2-16" @click.native="getMenuTree('province','山东省')">山东省</el-menu-item>
                <el-menu-item index="2-17" @click.native="getMenuTree('province','河南省')">河南省</el-menu-item>
                <el-menu-item index="2-18" @click.native="getMenuTree('province','湖北省')">湖北省</el-menu-item>
                <el-menu-item index="2-19" @click.native="getMenuTree('province','湖南省')">湖南省</el-menu-item>
                <el-menu-item index="2-20" @click.native="getMenuTree('province','广东省')">广东省</el-menu-item>
                <el-menu-item index="2-21" @click.native="getMenuTree('province','广西壮族自治区')">广西壮族自治区</el-menu-item>
                <el-menu-item index="2-22" @click.native="getMenuTree('province','海南省')">海南省</el-menu-item>
                <el-menu-item index="2-23" @click.native="getMenuTree('province','重庆市')">重庆市</el-menu-item>
                <el-menu-item index="2-24" @click.native="getMenuTree('province','贵州省')">贵州省</el-menu-item>
                <el-menu-item index="2-25" @click.native="getMenuTree('province','云南省')">云南省</el-menu-item>
                <el-menu-item index="2-26" @click.native="getMenuTree('province','西藏自治区')">西藏自治区</el-menu-item>
                <el-menu-item index="2-27" @click.native="getMenuTree('province','陕西省')">陕西省</el-menu-item>
                <el-menu-item index="2-28" @click.native="getMenuTree('province','甘肃省')">甘肃省</el-menu-item>
                <el-menu-item index="2-29" @click.native="getMenuTree('province','青海省')">青海省</el-menu-item>
                <el-menu-item index="2-30" @click.native="getMenuTree('province','宁夏回族自治区')">宁夏回族自治区</el-menu-item>
                <el-menu-item index="2-31" @click.native="getMenuTree('province','新疆维吾尔自治区')">新疆维吾尔自治区</el-menu-item>



              </el-submenu>

            </el-menu>
          </el-aside>

          <el-container>


            <el-main>
              <el-row>
                <el-col ><div style="background-color: rgb(240,246,253);border-radius: 4px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">

                  <el-row :gutter="20" class="tital" >
                    <h1>{{tiname}}</h1>
                  </el-row>

                </div>

                </el-col>
              </el-row>
              <el-table :data="tableData" border stripe >
                <el-table-column  label="序号" align="center" width="49">
                  <template slot-scope="scope">
                    {{scope.$index+1}}
                  </template>
                </el-table-column>
                <el-table-column prop="code" label="学校标识码" align="center" width="100">
                </el-table-column>
                <el-table-column prop="schoolname" label="学校名称" align="center" width="280">
                  <template slot-scope="scope">
                    <a :href="scope.row.link" target="_blank" class="buttonText">{{scope.row.schoolname}}</a>
                  </template>
                </el-table-column>
                <el-table-column prop="province" label="所在地区" align="center" width="63">
                </el-table-column>

                <el-table-column prop="city" label="所在城市" align="center" width="63">
                </el-table-column>
                <el-table-column prop="department" label="主管部门" align="center" width="193">
                </el-table-column>
                <el-table-column prop="level" label="办学层次" align="center" width="63">
                </el-table-column>
                <el-table-column prop="type" label="高校类型" align="center">
                </el-table-column>

              </el-table>

            </el-main>
          </el-container>


        </el-container>
      </el-col>
      <el-col :span="4"><div class="grid-content"></div></el-col>
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


  name: 'Home',
  data() {
    return {
      tableData: [],
      default_openeds_array: "['1','2']",
    }
  },
  tdata(){
    return{
      tiname:"null"
    }
  },
  created() {
    //this.getMenuTree()
  },
  methods: {


    getMenuTree(key,value) {
      // /api/pschool  "/school"
      this.tiname =value
      let formData = new FormData
      formData.append("key",key)
      formData.append("value",value)
      this.$axios.post("http://localhost:8081/api/pschool",formData).then(res => {
        this.tableData = res.data
      })
    },
    editHandle(){
      this.$axios.get("/click").then(res => {
        this.tableData = res.data
      })
    },

    handleSelect(key, keyPath){
      console.log(key, keyPath);
      if (key == '1-1-1'){
        this.currentView = 'componnts'
      }
    },
    handleOpen(key){
      this.default_openeds_array.push(key);
    }


  }

}
</script>

<style>
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
</style>