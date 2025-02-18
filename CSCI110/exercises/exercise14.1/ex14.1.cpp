/*
        Chapter 14 Example 1
        Author: Dan Chen
*/

#include <iostream>

using namespace std;

class Box
{
private:
    int length;
    int width;
    int height;

public:
    void SetBox(int aLength, int aWidth, int aHeight)
    {
        /*mutator method*/
        length = aLength;
        width = aWidth;
        height = aHeight;
        return;
    }

    int getLength()
    {
        /*accessor method*/
        return length;
    }

    int getWidth()
    {
        /*accessor method*/
        return width;
    }

    int getHeight()
    {
        /*accessor method*/
        return height;
    }

    int calculateSurfaceArea()
    {
        /*calculate the surface area of box*/
        return 2 * (length * width + width * height + height * length);
    }

    int calculateVolumn()
    {
        /*calculate the volumn of box */
        return length * width * height;
    }

    void printBox()
    {
        /*print the area and column of box*/
        cout << "The area of the box is " << calculateSurfaceArea() << endl;
        cout << "The volumn of the box is " << calculateVolumn() << endl;
        return;
    }
};

    void main()
    {
        Box box1;
        box1.SetBox(3, 4, 5);
        cout << "The length of the box is " << box1.getLength() << endl;
        cout << "The width of the box is " << box1.getWidth() << endl;
        cout << "The height of the box is " << box1.getHeight() << endl;
        box1.printBox();
        return;
    }