// assignment 2
// pair 043
// Wright Steven
// wrights
// Wang Shiyu
// shiyu

/*
                                    +-------------------------------+
                                    |                               |
                                    v                               |
                       +-------------------------+                  |
                       |          IPizza         |                  |
                       +-------------------------+                  |
                                    ^                               |
                                    |                               |
              +---------------------+-------------------+           |
       +------+--------+                      +---------+------+    |
       |     Plain     |                      |     Fancy      |    |
       |---------------|                      |----------------|    |
       |String   crust |                      |IPizza   base   <----+
       |               |                      |                |
       |String   cheese|                      |String   toping |
       +---------------+                      +----------------+
*/

interface IPizza {
};

class Plain implements IPizza {
    String crust;
    String cheese;

    Plain(String crust, String cheese) {
        this.crust = crust;
        this.cheese = cheese;
    }
}

class Fancy implements IPizza {
    IPizza base;
    String topping;

    Fancy(IPizza base, String toping) {
        this.base = base;
        this.topping = toping;
	}
}