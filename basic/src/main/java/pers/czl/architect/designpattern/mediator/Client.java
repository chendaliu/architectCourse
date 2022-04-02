package pers.czl.architect.designpattern.mediator;

import pers.czl.architect.designpattern.mediator.colleague.AbstractDatabase;
import pers.czl.architect.designpattern.mediator.colleague.EsDatabase;
import pers.czl.architect.designpattern.mediator.colleague.MysqlDatabase;
import pers.czl.architect.designpattern.mediator.colleague.RedisDatabase;
import pers.czl.architect.designpattern.mediator.mediator.Mediator;

import java.util.Arrays;

/**
 * 中介者模式，又叫调停者模式
 * 多个同事类相互协作的时候，这些同事类相互调用链就像蜘蛛网，耦合性非常强。
 * 引入中介者来解耦，将原本分布于这些同事类的行为集中在一起，若要改变行为可以生成新的中介者子类
 * 缺点：中介者类中包含了大量同事类之间的交互细节，可能导致中介者类非常复杂，难以维护。
 *
 * 角色：
 * Mediator（抽象中介者）
 * ConcreteMediator（具体中介者）
 * Colleague（抽象同事类）
 * ConcreteColleague（具体同事类）
 *
 * 案例：有三种数据库 Mysql、Redis、Elasticsearch，其中的 Mysql 作为主数据库，
 *  当增加一条数据时需要同步到另外两个数据库中；Redis 作为缓存数据库，当增加一条数据时不需要同步到另外另个数据库；
 *  而 Elasticsearch 作为大数据查询数据库，有一个统计功能，当增加一条数据时只需要同步到 Mysql
 **/
public class Client {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        AbstractDatabase mysqlDatabase = new MysqlDatabase(mediator);
        AbstractDatabase esDatabase = new EsDatabase(mediator);
        AbstractDatabase redisDatabase = new RedisDatabase(mediator);
        mediator.regist(Arrays.asList(mysqlDatabase, esDatabase, redisDatabase));

        //mysqlDatabase.add("我是mysql添加的数据");
        //esDatabase.add("我是es添加的数据");
        redisDatabase.add("我是redis添加的数据");

        mediator.showDatas();

    }

}