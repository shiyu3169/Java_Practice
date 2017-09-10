class Person {
    String  name;
    int     age;
    String  gender;
    Address address;

    Person(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    // is this person from the same city?
    boolean sameCity(Person other) {
        return this.address.sameCity(other.address);
    }

    // is this person from the same state but a different city?
    boolean sameStateOnly(Person other) {
        return this.address.sameState(other.address)
                && !this.address.sameCity(other.address);
    }
}

class Address {
    String city;
    String state;

    Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    // is this address in the same city?
    boolean sameCity(Address other) {
        return this.city.equals(other.city) &&
               this.sameState(other);
    }

    // is this address in the same state?
    boolean sameState(Address other) {
        return this.state.equals(other.state);
    }
}