#s4e-load-tests

Welcome do s4e-load-tests repository!

To run from console one single specific test: mvn gatling:test -Dgatling.simulationClass=package+.+className

e.g. mvn gatling:test -Dgatling.simulationClass=pl.cyfronet.s4e.*

To convert saved .har file you need to run Recorder

To run test inside IDE you need to run Engine