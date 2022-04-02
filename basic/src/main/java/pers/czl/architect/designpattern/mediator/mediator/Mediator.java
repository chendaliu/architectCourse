package pers.czl.architect.designpattern.mediator.mediator;

import pers.czl.architect.designpattern.mediator.colleague.AbstractDatabase;
import pers.czl.architect.designpattern.mediator.colleague.EsDatabase;
import pers.czl.architect.designpattern.mediator.colleague.MysqlDatabase;
import pers.czl.architect.designpattern.mediator.colleague.RedisDatabase;

/**
 * 中介者类
 * @author: daliu
 * @date: 2022-04-02 11:11
 **/
public class Mediator extends AbstractMediator {

    @Override
    public void sync(AbstractDatabase database, String data) {
        //redis添加数据同步到es和redis
        if (database instanceof MysqlDatabase) {
            this.databaseList.forEach(db -> {
                if (db instanceof EsDatabase || db instanceof RedisDatabase) {
                    db.addData(data);
                }
            });
            return;
        }

        //es同步到mysql
        if (database instanceof EsDatabase) {
            this.databaseList.forEach(db -> {
                if (db instanceof MysqlDatabase) {
                    db.addData(data);
                }
            });
        }

        //redis不同步
    }
}