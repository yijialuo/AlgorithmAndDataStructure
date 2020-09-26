package dataStructure.link;

class ShNode {
    public int no;
    public String name;
    public String nickname;
    public ShNode nextNode;

    public ShNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

class SingleLink {
    //不存放数据
    private ShNode head;

    public SingleLink() {
        head = new ShNode(0, "", "");
    }

    //添加节点，找到最后的节点，把最后节点的next赋值为新节点
    public void addLink(ShNode shNode) {
        ShNode tem = head;
        //讲tem指向最后一个节点
        while (true) {
            //如果下一个节点为空，跳出循环，
            if (tem.nextNode == null) {
                break;
            }
            tem = tem.nextNode;
        }
        //循环过后，tem指向最后一个节点
        tem.nextNode = shNode;
    }

    //打印节点
    public void showLink() {
        if (head.nextNode == null) {
            System.out.println("当前链表为空");
            return;
        }
        ShNode temp = head.nextNode;
        while (true) {
            //temp为空就结束打印
            if (temp == null) {
                return;
            }
            //temp不为空就打印
            System.out.println(temp);
            //打印完，temp后移
            temp = temp.nextNode;
        }
    }
}

public class SingleLinkDemo {
    public static void main(String[] args) {
        ShNode shNode1=new ShNode(1,"宋江","及时雨");
        ShNode shNode2=new ShNode(2,"吴用","智多星");
        ShNode shNode3=new ShNode(3,"林冲","豹子头");
        ShNode shNode4=new ShNode(4,"鲁智深","花和尚");
        SingleLink singleLink=new SingleLink();
        singleLink.addLink(shNode1);
        singleLink.addLink(shNode3);
        singleLink.addLink(shNode2);
        singleLink.addLink(shNode4);
        singleLink.showLink();
    }
}
