/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simpletexteditor;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Nhat Anh
 */
public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        StringBuilder text = new StringBuilder();
        Stack<String> undoStack = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();

            switch (type) {
                case 1:
                    // Append
                    String appendString = scanner.next();
                    undoStack.push(text.toString());
                    text.append(appendString);
                    break;

                case 2:
                    // Delete
                    int k = scanner.nextInt();
                    undoStack.push(text.toString());
                    text.delete(text.length() - k, text.length());
                    break;

                case 3:
                    // Print
                    int index = scanner.nextInt() - 1;
                    System.out.println(text.charAt(index));
                    break;

                case 4:
                    // Undo
                    if (!undoStack.isEmpty()) {
                        text = new StringBuilder(undoStack.pop());
                    }
                    break;
            }
        }

        scanner.close();
    }
}
