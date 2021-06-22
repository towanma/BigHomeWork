import requests, json, pymysql

# url = 'https://www.cingta.com/school/api/name_uni_list/name=&'  # 爬取数据的接口url
# schooldatajson = requests.get(url).json()  # 将返回的Response列表数据转成json格式
# with open('data.json', 'w', encoding='utf-8') as f:  # 将json数据保存到本地
#     f.write(json.dumps(schooldatajson, ensure_ascii=False, indent=4, ))


def creattable(db):  # 连接数据库并创建一张表
    cursor = db.cursor()
    cursor.execute("SELECT VERSION()")
    data = cursor.fetchone()
    print("Database version : %s " % data)  # 如正常显示数据库版本，则表示数据库连接正常
    cursor.execute("DROP TABLE IF EXISTS allschool")  # 如果存在此表，将此表删除，重新创建表
    sql = """CREATE TABLE allschool (
       lineid INT NOT NULL,
       code VARCHAR(100),
       schoolname VARCHAR(100) NOT NULL,
       province VARCHAR(100) NOT NULL,
       city VARCHAR(100) NOT NULL,
       department VARCHAR(100) NOT NULL,
       level VARCHAR(100) NOT NULL,
       type VARCHAR(100),
       link VARCHAR(100))"""
    cursor.execute(sql)  # 根据爬虫返回的数据类型，创建一张表


def insertdata(db):
    with open('data.json', encoding='utf-8') as f:
        jsonloded = json.load(f)  # 读取json数据
        end = jsonloded['data']['total']  # 解析json文件中tatal的值获得数据大小
        for num in range(0, end):
            try:
                index = jsonloded['data']['list'][num]  # 设定索引
                result = []
                result.append((index['lineid'], index['code'], index['schoolname'],
                               index['province'], index['city'], index['department'], index['level'],
                               index['type'], index['link']))  # 将指定索引处的各项值传入数组
                print(result)
                inesrt_sql = "insert into allschool(lineid, code, schoolname, province, city, department, level,type,link ) values (%s,%s,%s,%s,%s,%s,%s,%s,%s)"
                cursor = db.cursor()
                cursor.executemany(inesrt_sql, result)  # 将sql语句和数组结合后向数据库发起执行操作
                db.commit()
            except Exception as e:
                db.rollback()
                print(str(e))
                break


if __name__ == "__main__":
    db = pymysql.connect(host="10.203.87.114", user="root", password="JS0577js0577@", database="softhomedb",
                         charset='utf8')
    cursor = db.cursor()
    creattable(db)
    insertdata(db)
    cursor.close()
