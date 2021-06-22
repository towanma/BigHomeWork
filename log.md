# 2021.6.16
通过使用浏览器的DevTools找到了https://www.cingta.com/school/ser 中的api接口  
接口rul:https://www.cingta.com/school/api/name_uni_list/  
加上FormData`name=&`后对该接口发起GET请求,发现会直接将所需的2787条院校信息以json格式返回

# 2021.6.18
在一台Centos8服务器上配置了Mysql，并开启了远程访问，将json数据解析后按条传入数据库

