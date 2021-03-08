#s4e-load-tests

Welcome do s4e-load-tests repository!

To run from console one single specific test: 
```
mvn gatling:test -Dgatling.simulationClass=package+.+className
```

or

```
mvn gatling:test -Dgatling.simulationClass=pl.cyfronet.s4e.*
```

To convert saved .har file you need to run Recorder

To run test inside IDE you need to run Engine

##CY n-thread test

Instalation
```
npm i # required node.js >= 12
```

To setup test run you have to change cy.visit at line 6 in `/cy-test/cypress/integration/product.spec.js` to point proper instance

Run
```
bash parallel.sh -t 3
```

-t -> number of threads
