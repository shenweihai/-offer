package 阿里订单拆分;//评测题目: 拆单问题

//评测题目: 拆单问题

import java.util.*;

public class MySplitOrders {

    public class Item {

        /**
         * 卖家用户id
         */
        long sellerId;

        /**
         * 商品价格，单位分
         */
        long price;

        public Item(long sellerId, long price) {
            this.sellerId = sellerId;
            this.price = price;
        }
    }

    public class Order {

        /**
         * 该订单对应的商品
         */
        List<Item> orderItems;

        /**
         * 该订单金额，单位分
         */
        long totalPrice;

        /**
         * 该订单对应的卖家userId
         */
        long sellerId;

        public Order(List<Item> orderItems, long totalPrice, long sellerId) {
            this.orderItems = orderItems;
            this.totalPrice = totalPrice;
            this.sellerId = sellerId;
        }
    }


    /**
     * 根据购物车的商品，生成相应的交易订单，根据如下规则
     * 1.每笔交易订单可以有多个商品
     * 2.每笔交易订单的商品只能是同一个卖家
     * 3.每笔交易商品的总价格不能超过1000元
     * 4.生成的交易订单数量最小
     *
     * @param items： 购物车所有商品
     */
    public List<Order> packageItemsToOrders(List<Item> items) {
        //先将相同sellerId的商品加在一起,key为sellerid,value为对应订单
        Map<Long, Order> map = new HashMap<>();
        for (Item item : items) {
            if (map.containsKey(item.sellerId)) {
                Order order = map.get(item.sellerId);
                order.totalPrice += item.price;
                order.orderItems.add(item);
            } else {
                Order order = new Order(new ArrayList<>(), item.price, item.sellerId);
                order.orderItems.add(item);
                map.put(order.sellerId, order);
            }
        }
        //最后结果
        List<Order> allOrder = new ArrayList<>();

        //找到>1000的订单
        map.forEach((sellerId, order) -> {
            if (order.totalPrice > 1000) {
                //拆分订单
                List<Order> orders = splitOrder(order);
                allOrder.addAll(orders);
            } else {
                allOrder.add(order);
            }
        });

        return allOrder;
    }

    /**
     * 拆分满1000的订单
     */
    public List<Order> splitOrder(Order order) {
        //按价格从小到大排序
        Collections.sort(order.orderItems, (i1, i2) -> (int) (i1.price - i2.price));
        //总订单
        List<Order> orders = new ArrayList<>();
        //遍历item列表，超过1000，则new 一个Order
        List<Item> items = order.orderItems;
        int min = 0;
        int max = items.size() - 1;
        //初始化当前订单
        List<Item> tmp = new ArrayList<>();
        tmp.add(items.get(max));
        Order currentOrder = new Order(tmp, items.get(max).price, order.sellerId);
        while (min < max) {
            if (currentOrder.totalPrice + items.get(min).price > 1000) {
                orders.add(currentOrder);
                max--;
                tmp = new ArrayList<>();
                tmp.add(items.get(max));
                currentOrder = new Order(tmp, items.get(max).price, order.sellerId);
            } else {
                currentOrder.orderItems.add(items.get(min));
                currentOrder.totalPrice += items.get(min).price;
                min++;
            }
        }
        orders.add(currentOrder);
        /*//当min=max时
        if (currentOrder.totalPrice + items.get(min).price <= 1000) {
            currentOrder.orderItems.add(items.get(min));
            currentOrder.totalPrice += items.get(min).price;
            orders.add(currentOrder);
        } else {
            ArrayList<Item> list = new ArrayList<>();
            list.add(items.get(min));
            currentOrder = new Order(list, items.get(min).price, order.sellerId);
            orders.add(currentOrder);
        }*/
        /*for(int i=0;i<order.orderItems.size();i++){
            //当前商品
            Item item = order.orderItems.get(i);
            currentOrder.totalPrice += item.price;
            //当前订单超过1000
            if(currentOrder.totalPrice>1000){
                //回退当前商品
                currentOrder.totalPrice = currentOrder.totalPrice - item.price;
                i--;
                //添加到结果
                orders.add(currentOrder);
                //new一个新的订单
                currentOrder = new Order(new ArrayList<>(),0,order.sellerId);
            }else{
                currentOrder.orderItems.add(item);
            }
        }
        //最后一个订单，不满1000
        orders.add(currentOrder);*/
        return orders;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MySplitOrders splitOrders = new MySplitOrders();
        List<Item> items = new ArrayList<>();
        Item item = splitOrders.new Item(1, 1);
        items.add(item);
        item = splitOrders.new Item(1, 1);
        items.add(item);
        item = splitOrders.new Item(1, 999);
        items.add(item);
        item = splitOrders.new Item(1, 999);
        items.add(item);
        List<Order> orders = splitOrders.packageItemsToOrders(items);
        for (Order order : orders) {
            System.out.println(order.sellerId + "," + order.totalPrice + "," + order.orderItems);
        }
    }
}