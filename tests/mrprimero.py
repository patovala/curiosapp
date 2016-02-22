#!/usr/bin/env python
# encoding: utf-8

################################################################################
#                                   MonkeyRuner for this project               #
# Descripción: Probar que tan bien podemos integrar monkeyruner al testing
#
################################################################################
from com.android.monkeyrunner import MonkeyRunner
# import commands
# import sys

# print """
m = "KFBWKSBTdGFydGluZyB0aGUgTW9ua2V5IFRlc3RpbmcgU2NyaXB0CiAgICAgICA" + \
    "gICBfXwogICAgW3ddIGMoLi4pbyAgICgKICAgICAgXF9fKC0pICAgIF9fKQogIC" + \
    "AgICAgICAgL1wgICAoCiAgICAgICAgIC8oXylfX18pCiAgICAgICAgIHcgL3wKI" + \
    "CAgICAgICAgIHwgXAogICAgICAgICBtICBtIAo="

print m.decode('base64')

device = MonkeyRunner.waitForConnection()

##########################################################################
#  estamos asumiendo que el paquete ya esta instalado, no hacemos mucho  #
##########################################################################
comp = "com.sonoman/com.sonoman.curiosapp.InicioActivity"
device.startActivity(component=comp)

MonkeyRunner.sleep(1)
result = device.takeSnapshot()
result.writeToFile("splash.png", "png")
print "screen 1 taken"
