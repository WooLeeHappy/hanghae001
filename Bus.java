public class Bus{
    int max_person;
    int now_person;
    int get_on_person;
    int charge;
    int money;
    static int bus_number;
    int count;
    int gas;
    int now_speed;
    boolean run;

    public Bus(int max_person, int gas, int charge) {
        this.bus_number += 1;
        this.now_person = 0;
        this.max_person = max_person;
        this.gas = gas;
        this.charge = 1000;
        this.run = true;
        System.out.println(bus_number + "번 차량의 배차가 완료되었습니다.\n 탑승가능 총 인원은 " + max_person + " 명이며, 요금은 " + charge + "원입니다.");
    }

    public void get_on_bus(int get_on_person) {
        if(max_person < get_on_person + now_person) {
            System.out.println("최대인원 " + max_person + "명을 넘어서는 " + (get_on_person + now_person - max_person) + "명의 승객은 타지 못했습니다.");
            this.now_person = max_person;
            charge += charge * (max_person - now_person);
            System.out.println("총 " + charge +" 원만큼의 돈을 벌었습니다.");
        } else {
            this.now_person += get_on_person;
            money += charge * get_on_person;
            System.out.println("현재 탑승인원은" + now_person + "명 입니다. \n 총 " + money +" 원만큼의 돈을 벌었습니다.");
        }
    }
    public void gas(int gas) {
        if(gas <= 10) {
            this.gas += gas;
            System.out.println("주유가 필요합니다.");
        } else if(gas < 0) {
            if(money >= 10000) {
                System.out.println("기름이 없어 차가 멈췄습니다. \n 기름차를 불렀습니다. 10000원의 비용이 청구됩니다.");
                this.gas = 100;
            } else {
                System.out.println("기름이 없어 차가 멈췄습니다. 또한 돈이 없어 현재상태를 차고지행이 됩니다.");
                run = false;
            }
        }
    }
}