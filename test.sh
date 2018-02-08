#!/bin/bash

for (( alpha = 0.05; alpha<= 0.5; alpha = alpha + 0.05 ))
do
   time java -cp "/Users/jurgen/Kent/IA/javAstar/src/" Main $alpha
done
