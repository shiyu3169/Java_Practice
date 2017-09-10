interface IPhoneChain {
};

class IPCmt implements IPhoneChain {
    IPCmt() {
    }
}

class Link implements IPhoneChain {
    Player      player;
    IPhoneChain first;
    IPhoneChain second;

    Link(Player player, IPhoneChain first, IPhoneChain second) {
        this.player = player;
        this.first = first;
        this.second = second;
    }
}

class Player implements IPhoneChain {
    String name;
    String phoneNum;

    Player(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }
}