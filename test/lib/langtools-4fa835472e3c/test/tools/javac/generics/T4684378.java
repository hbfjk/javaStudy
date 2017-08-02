/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 4684378
 * @summary generics: verify error in generated bytecode
 * @author gafter
 *
 * @compile  T4684378.java
 * @run main T4684378
 */

import java.util.Stack;
public class T4684378 {
    public static void main(String[] argv) {
        Stack<String> bar = new Stack<String>();
        String foo;

        // Compiles, but causes verify error
        foo=(bar.empty()?"":bar.peek()).intern();

        // The following two work fine
        foo = (bar.empty()?"":bar.peek().intern());
        foo = (bar.empty()?"":(String)bar.peek()).intern();
    }
}
