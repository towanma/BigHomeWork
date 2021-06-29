# 2021.6.16
通过使用浏览器的DevTools找到了https://www.cingta.com/school/ser 中的api接口  
接口rul:https://www.cingta.com/school/api/name_uni_list/  
加上FormData`name=&`后对该接口发起GET请求,发现会直接将所需的2787条院校信息以json格式返回

# 2021.6.18
在一台Centos8服务器上配置了Mysql，并开启了远程访问，将json数据解析后按条传入数据库

# 2021.6.27
前端初步完成，用端口模拟工具模拟了数据的输入

# 2021.6.28
后端接口开发完毕，mysql中的数据可以通过后端接口到达前端

# 2021.6.29
对前后端的数据进行了整合，添加了分页查询和联想查询，整个前后端分离开发完毕
