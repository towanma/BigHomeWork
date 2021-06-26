const Mock = require('mockjs')

const Random = Mock.Random

let Result = [
    {
        "lineid": 1,
        "code": "4111010001",
        "schoolname": "北京大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "一流大学A类,985,211",
        "link": "http://www.pku.edu.cn/"
    },
    {
        "lineid": 2,
        "code": "4111010002",
        "schoolname": "中国人民大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "一流大学A类,985,211",
        "link": "http://www.ruc.edu.cn/"
    },
    {
        "lineid": 3,
        "code": "4111010003",
        "schoolname": "清华大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "一流大学A类,985,211",
        "link": "http://www.tsinghua.edu.cn/publish/thu2018/index.html"
    },
    {
        "lineid": 4,
        "code": "4111010004",
        "schoolname": "北京交通大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "211,一流学科",
        "link": "http://www.njtu.edu.cn/"
    },
    {
        "lineid": 5,
        "code": "4111010005",
        "schoolname": "北京工业大学",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "211,一流学科",
        "link": "http://www.bjut.edu.cn/"
    },
    {
        "lineid": 6,
        "code": "4111010006",
        "schoolname": "北京航空航天大学",
        "province": "北京市",
        "city": "北京市",
        "department": "工业和信息化部",
        "level": "本科",
        "type": "一流大学A类,985,211",
        "link": "http://www.buaa.edu.cn/"
    },
    {
        "lineid": 7,
        "code": "4111010007",
        "schoolname": "北京理工大学",
        "province": "北京市",
        "city": "北京市",
        "department": "工业和信息化部",
        "level": "本科",
        "type": "一流大学A类,985,211",
        "link": "http://www.bit.edu.cn/"
    },
    {
        "lineid": 8,
        "code": "4111010008",
        "schoolname": "北京科技大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "211,一流学科",
        "link": "http://www.ustb.edu.cn/"
    },
    {
        "lineid": 9,
        "code": "4111010009",
        "schoolname": "北方工业大学",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "http://www.ncut.edu.cn/"
    },
    {
        "lineid": 10,
        "code": "4111010010",
        "schoolname": "北京化工大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "211,一流学科",
        "link": "http://www.buct.edu.cn/"
    },
    {
        "lineid": 11,
        "code": "4111010011",
        "schoolname": "北京工商大学",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "http://www.btbu.edu.cn/"
    },
    {
        "lineid": 12,
        "code": "4111010012",
        "schoolname": "北京服装学院",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "http://www.bift.edu.cn/"
    },
    {
        "lineid": 13,
        "code": "4111010013",
        "schoolname": "北京邮电大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "211,一流学科",
        "link": "https://www.bupt.edu.cn/"
    },
    {
        "lineid": 14,
        "code": "4111010015",
        "schoolname": "北京印刷学院",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "http://www.bigc.edu.cn/"
    },
    {
        "lineid": 15,
        "code": "4111010016",
        "schoolname": "北京建筑大学",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "http://www.bucea.edu.cn/"
    },
    {
        "lineid": 16,
        "code": "4111010017",
        "schoolname": "北京石油化工学院",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "http://www.bipt.edu.cn/"
    },
    {
        "lineid": 17,
        "code": "4111010018",
        "schoolname": "北京电子科技学院",
        "province": "北京市",
        "city": "北京市",
        "department": "中央办公厅",
        "level": "本科",
        "type": "",
        "link": "http://www.besti.edu.cn/"
    },
    {
        "lineid": 18,
        "code": "4111010019",
        "schoolname": "中国农业大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "一流大学A类,985,211",
        "link": "http://www.cau.edu.cn/"
    },
    {
        "lineid": 19,
        "code": "4111010020",
        "schoolname": "北京农学院",
        "province": "北京市",
        "city": "北京市",
        "department": "北京市",
        "level": "本科",
        "type": "",
        "link": "https://www.bac.edu.cn/"
    },
    {
        "lineid": 20,
        "code": "4111010022",
        "schoolname": "北京林业大学",
        "province": "北京市",
        "city": "北京市",
        "department": "教育部",
        "level": "本科",
        "type": "211,一流学科",
        "link": "http://www.bjfu.edu.cn/"
    }


]

Mock.mock('/school','get',()=>{
    return Result
})