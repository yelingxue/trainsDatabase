# trainsDatabase
A small stand-alone database developed by J2SE to achieve the following functions

1) Query function, enter the number of train, query the train's route information (not query the remaining tickets, only query station and timetable) 
2) query the start and arrival places, query the number of trains on a specified date, sort the departure time 
3) according to the query results , Provides ticket sales function, when the number of tickets is greater than the balance, an error is reported. 4) Refund function, input order number,  Complete refund
5) View sales function, report for only view own sales

火车站票务管理系统实现车次管理;实现车次及价格管理(含到各站的价格);
实现业务员管理;
实现车票销售管理,车票销售时不能超员, 并自动修改剩余的座位数(用触发器实现);
创建存储过程统计指定车次指定发车时间的车票销售情况;创建存储过程统计指定日期各业务员车票的销售收入（只看自己的视图）;
实现退票管理,退票时自动修改相应车次的剩余座位数(用触发器实现);
创建表间关系。
