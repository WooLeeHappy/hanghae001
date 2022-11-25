public class Taxi {
    int normal_charge = 100;
    int ultra_charge = 200;
    int normal_km = 5;
    int result_charge;
    int money;
    static int taxi_number;
    int count;
    int gas = 100;
    int now_speed;
    int status = 0;  // 0 : 운행전, 1 : 손님태우기가능상태, 2: 손님탑승상태

    Taxi(int taxi_number) {
        if(gas > 10) {
            status = 1;
            this.taxi_number += 1;
            System.out.println("운행을 시작합니다.");
        } else {
            System.out.println("충분한 주유가 필요합니다.");
        }
    }

    void get_on_guest(int how_far) {
        if(status == 1) {
            if(how_far <= normal_km) {
                result_charge += how_far * normal_charge;
                now_speed = 10;
                System.out.println("손님을 태웠고, 목적지까지 총 " + result_charge + "원 입니다.");
                System.out.println("속도 " + now_speed + "만큼의 속력으로 출발했습니다.");
                status = 2;
            } else if(how_far < 0) {
                System.out.println("제대로 된 입력값이 아닙니다.");
            } else {
                result_charge += (normal_km * normal_charge) + (ultra_charge * (how_far - normal_km));
                now_speed = 10;
                System.out.println("손님을 태웠고, 목적지까지 총 "+ how_far +" 만큼의 거리이동으로" + result_charge + "원 입니다.");
                System.out.println("속도 " + now_speed + "만큼의 속력으로 출발했습니다.");
                status = 2;
            }
        } else {
            System.out.println("탑승가능한 상태가 아닙니다.");
        }
    }
    void change_speed(int speed) {
        if( now_speed < 0 ) {
            now_speed = 0;
            System.out.println("급브레이크를 밟았습니다. 속력은 0이 됩니다.");
        } else {
            now_speed += speed;
            System.out.println("속도를 변경합니다. 현재속도는 " + now_speed + " 만큼의 속력입니다.");
        }
    }
    void get_out_guest() {
        money += result_charge;
        status = 1;
        System.out.println("손님이 내렸습니다." + result_charge + "만큼의 비용을 지불했습니다.");
        result_charge = 0;
    }
    void end_game() {
        switch (status) {
            case 0:
                System.out.println("이미 운행중이지 않습니다.");
                break;
            case 1:
                System.out.println("운행을 종료합니다.");
                status = 0;
                break;
            case 2:
                System.out.println("손님을 내린 후 종료해 주세요.");
                break;
        }
    }
}

