package tests;

import core.Utilities;

//
// Test for the formatting options defined in core.Utilities.
//
// Tests include the ease of color printing, block printing and the use of
// widths.
//
// @author Alex Petersen <theoperatore@gmail.com>
//
public class OutputFormatTest {

    public static void main(String[] args) {

        String block = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis, nisi eget scelerisque interdum, ante metus tincidunt ipsum, ut aliquet turpis nibh sed massa. Sed sed faucibus mauris. Fusce ut tellus sed mi rhoncus ultricies sit amet eu elit. Vivamus eleifend ante non ipsum pellentesque molestie. Suspendisse at elit ut felis lacinia tempus sed eu magna. Aliquam vestibulum pellentesque quam et eleifend. Cras pulvinar nunc in orci bibendum tristique. Nullam laoreet massa a fringilla facilisis. Quisque ac rutrum turpis. Sed accumsan hendrerit porta. Integer aliquet elit in turpis semper, a luctus magna ullamcorper. Duis vel vehicula lorem, non lobortis arcu. Mauris imperdiet nec odio nec rutrum. Sed rhoncus magna ac nisl feugiat fringilla.";

        String part = "";
        //print a block with width argument
        for (int i = 0; i < block.length(); i++) {
            if (i == (block.length() - 1)) {
                String out = String.format("%1$-5s %2$-70s"," ",part);
                Utilities.println(Utilities.MAGENTA,out);
            }
            else if (i != 0 && i % 70 == 0) {
                String out = String.format("%1$-5s %2$-70s"," ",part);
                Utilities.println(Utilities.MAGENTA,out);
                part = "";
            }
            else {
                part += block.charAt(i);
            }
        }
    }


}