package pers.czl.architect.designpattern.chainOfResponsibility;


/**
 * 责任链模式 <br/>
 * 应用场景：一个请求需要多个对象协作处理。 <br/>
 * 优点: <br/>
 *  1.请求的发送者和接受者解耦 <br/>
 *  2.可以控制执行顺序 <br/>
 *  3.符合开闭原则和单一职责原则 <br/>
 */
public class ChainOfResponsibility2 {
    /**
     * 测试场景：采购员采购商品，根据不同的商品价格，需要不同级别的领导审批 <br/>
     * 价格小于100时经理审批 <br/>
     * 价格100~1000时总监审批 <br/>
     * 价格1000~10000时高级总监审批 <br/>
     *
     * @param args
     */
    public static void main(String[] args) {
        //实例化领导人
        Approve zhao = new Manager("赵经理");
        Approve wang = new Director("王总监");
        Approve chen = new HighDirector("陈高级总监");
        //设置领导人审批顺序
        zhao.setNext(wang).setNext(chen);

        //采购商品审批
        CommodityRequest book = new CommodityRequest("一本书", 50);
        zhao.proccess(book);

        CommodityRequest drink = new CommodityRequest("饮料", 200);
        zhao.proccess(drink);

        CommodityRequest pc = new CommodityRequest("电脑", 9000);
        zhao.proccess(pc);
    }

}

/**
 * 商品请求类
 */
class CommodityRequest {
    public CommodityRequest(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    private Integer price;
    private String name;

    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 抽象审批类
 */
abstract class Approve {
    protected Approve next;
    protected String name;//审批人姓名

    public Approve(String name) {
        this.name = name;
    }
    protected abstract boolean proccess(CommodityRequest commodity);
    public Approve setNext(Approve next) {
        return this.next = next;
    }
}

/**
 * 审批人：经理
 */
class Manager extends Approve {
    public Manager(String name) {
        super(name);
    }
    @Override
    protected boolean proccess(CommodityRequest commodity) {
        if (commodity.getPrice() < 100) {
            System.out.println("经理：" + this.name + "审批通过，商品：" + commodity.getName());
            return true;
        } else {
            return this.next.proccess(commodity);
        }
    }
}

/**
 * 审批人：总监
 */
class Director extends Approve {
    public Director(String name) {
        super(name);
    }
    @Override
    protected boolean proccess(CommodityRequest commodity) {
        if (commodity.getPrice() < 1000) {
            System.out.println("总监：" + this.name + "审批通过，商品：" + commodity.getName());
            return true;
        } else {
            return this.next.proccess(commodity);
        }
    }
}

/**
 * 审批人：高级总监
 */
class HighDirector extends Approve {
    public HighDirector(String name) {
        super(name);
    }
    @Override
    protected boolean proccess(CommodityRequest commodity) {
        if (commodity.getPrice() < 10000) {
            System.out.println("高级总监：" + this.name + "审批通过，商品：" + commodity.getName());
            return true;
        } else {
            return this.next.proccess(commodity);
        }
    }
}