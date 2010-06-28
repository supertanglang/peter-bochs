#!/bin/bash

cd ../bin/
javah -jni peter.instrument.MySHStub
mv peter_instrument_MySHStub.h ../libPeterBochs/
