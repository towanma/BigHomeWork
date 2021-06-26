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
            <el-menu :default-openeds="['1']">
              <el-submenu index="1">
                <template slot="title"><i class="el-icon-plus"></i>高校类型</template>
                <el-menu-item class="clickDown" index ="1-1" @click.native="editHandle()" v-click-down>一流大学</el-menu-item>
                <el-menu-item index="1-2">一流学科</el-menu-item>
                <el-menu-item index="1-3">985高校</el-menu-item>
                <el-menu-item index="1-4">211高校</el-menu-item>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title"><i class="el-icon-plus"></i>所在地区</template>
                <el-menu-item index="2-1">北京市</el-menu-item>
                <el-menu-item index="2-2">四川省</el-menu-item>
                <el-menu-item index="2-3">天津市</el-menu-item>
                <el-menu-item index="2-4">河北省</el-menu-item>
                <el-menu-item index="2-5">山西省</el-menu-item>
                <el-menu-item index="2-6">内蒙古自治区</el-menu-item>
                <el-menu-item index="2-7">辽宁省</el-menu-item>
                <el-menu-item index="2-8">吉林省</el-menu-item>
                <el-menu-item index="2-9">黑龙江省</el-menu-item>
                <el-menu-item index="2-10">上海市</el-menu-item>
                <el-menu-item index="2-11">江苏省</el-menu-item>
                <el-menu-item index="2-12">浙江省</el-menu-item>
                <el-menu-item index="2-13">安徽省</el-menu-item>
                <el-menu-item index="2-14">福建省</el-menu-item>
                <el-menu-item index="2-15">江西省</el-menu-item>
                <el-menu-item index="2-16">山东省</el-menu-item>
                <el-menu-item index="2-17">河南省</el-menu-item>
                <el-menu-item index="2-18">湖北省</el-menu-item>
                <el-menu-item index="2-19">湖南省</el-menu-item>
                <el-menu-item index="2-20">广东省</el-menu-item>
                <el-menu-item index="2-21">广西壮族自治区</el-menu-item>
                <el-menu-item index="2-22">海南省</el-menu-item>
                <el-menu-item index="2-23">重庆市</el-menu-item>
                <el-menu-item index="2-24">贵州省</el-menu-item>
                <el-menu-item index="2-25">云南省</el-menu-item>
                <el-menu-item index="2-26">西藏自治区</el-menu-item>
                <el-menu-item index="2-27">陕西省</el-menu-item>
                <el-menu-item index="2-28">甘肃省</el-menu-item>
                <el-menu-item index="2-29">青海省</el-menu-item>
                <el-menu-item index="2-30">宁夏回族自治区</el-menu-item>
                <el-menu-item index="2-31">新疆维吾尔自治区</el-menu-item>



              </el-submenu>

            </el-menu>
          </el-aside>

          <el-container>


            <el-main>
              <el-row>
                <el-col ><div style="background-color: rgb(240,246,253);border-radius: 4px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">

                  <el-row :gutter="20" class="tital">
              <h1>asdf</h1>
                  </el-row>

                </div>

                </el-col>
              </el-row>
              <el-table :data="tableData" border stripe >
                <el-table-column prop="lineid" label="序号" align="center" width="49">
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
      tableData: []
    }
  },
  created() {


  },
  methods: {
    getMenuTree() {
      this.$axios.get("/school").then(res => {
        this.tableData = res.data
      })
    },
    editHandle(){
      this.$axios.get("/click").then(res => {
        this.tableData = res.data
      })


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