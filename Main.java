import jdk.internal.util.ArraysSupport;
import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.*;

public class Main {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        BookManager M = new BookManager();
        M.menu(input);
    }
}
