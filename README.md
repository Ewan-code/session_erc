# session_erc
项目介绍
本项目由Client与Server组成

Client：
调用远程服务端模拟开启停止会话(Session)

Server：
收到请求后一秒后返回200 OK

实现功能：
1. 在console输入id和时长（秒）封装为post请求体，使用RestTemplate调用Server的接口。
2. 用于执行session的Start与Stop功能
3. 使用log4j2记录Session
4. 利用线程池，使每一个session的请求都使用一个独立线程，并通过线程内的睡眠来延时发送stop
