#!/bin/bash

while getopts t: option
do
# shellcheck disable=SC2220
case "${option}"
in
t) THREADS=${OPTARG};;
esac
done

run_product_spec(){
  echo "Run nth: $1"
  npx cypress run
  sleep 1
}

if [ -z ${THREADS+x} ]; then
  exit 0
fi

for i in $(seq 1 $THREADS);
do
	run_product_spec $i &
done

wait
echo "All products specs done"
