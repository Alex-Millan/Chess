#!/bin/bash

#This is temporary. It will be better to use a Makefile.
rm StartChess.class Chessboard.class ChessPiece.class ChessPawn.class 2> /dev/null
#echo "Compiling and running..."
javac StartChess.java Chessboard.java ChessPiece.java ChessPawn.java
java StartChess

