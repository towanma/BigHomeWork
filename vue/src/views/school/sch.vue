<template>
  <div class="sch">

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



    <el-container  style="; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu :default-openeds="['1', '3']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-plus"></i>导航一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-plus"></i>导航二</template>

            <el-menu-item index="2-1">选项1</el-menu-item>
            <el-menu-item index="2-2">选项2</el-menu-item>

          </el-submenu>

        </el-menu>
      </el-aside>

      <el-container>


        <el-main>

          <el-table :data="tableData" border stripe style="width: 100%">
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

  </div>
</template>

<script>
// @ is an alias to /src


export default {
  name: 'Home',
  data() {
    return {
      tableData: []
    }
  },
  created() {
    this.getMenuTree()
  },
  methods: {
    getMenuTree() {
      this.$axios.get("/school").then(res => {
        this.tableData = res.data
      })
    }
  }

}
</script>