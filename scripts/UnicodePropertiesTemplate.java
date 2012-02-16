/*
 * Permission is hereby granted, free of charge, to any person obtaining a copy of 
 * this software and associated documentation files (the "Software"), to deal in 
 * the Software without restriction, including without limitation the rights to 
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies 
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
 * SOFTWARE.
 */
package org.jcodings.unicode;

import org.jcodings.Config;
import org.jcodings.util.CaseInsensitiveBytesHash;


public class UnicodeProperties {
    static final int[][]CodeRangeTable = Config.USE_UNICODE_PROPERTIES ?
            new int[][] {
%{extcrs}
            } : new int[][] {
%{stdcrs}
            };

    private static final byte CTypeNameTable[][] = Config.USE_UNICODE_PROPERTIES ?
            new byte[][] {
%{extnames}
            } : new byte[][] {
%{stdnames}
            };

    private static CaseInsensitiveBytesHash<Integer> initializeCTypeNameTable() {
        CaseInsensitiveBytesHash<Integer> table = new CaseInsensitiveBytesHash<Integer>();
        for (int i=0; i<CTypeNameTable.length; i++) table.putDirect(CTypeNameTable[i], i);

        return table;
    }
    
    static final CaseInsensitiveBytesHash<Integer> CTypeNameHash = initializeCTypeNameTable();
}
