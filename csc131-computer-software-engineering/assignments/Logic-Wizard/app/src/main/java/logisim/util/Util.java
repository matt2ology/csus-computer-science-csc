package logisim.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import logisim.AbstractScreenPartition;
import logisim.Grid;
import logisim.IScreenPartition;
import logisim.tiles.components.Component;

public class Util {

    public static Rect getRect(Point point, Size size) {
        return new Rect(point.x, point.y, point.x + size.width, point.y + size.height);
    }

    public static void drawTileOutline(Component component, Grid grid, Canvas canvas, Paint paint) {
        drawTileOutline(component.getPoint(), grid, canvas, paint);
    }

    public static void drawTileOutline(GridPoint gridPoint, Grid grid, Canvas canvas, Paint paint) {
        LocalPoint pos = grid.convertToLocalPoint(gridPoint);
        pos.offset(grid.getOrigin().x, grid.getOrigin().y);
        Size size = new Size(grid.tileLength, grid.tileLength);
        int lineWidth = size.width / 8;
        int lineHeight = size.height / 8;
        // Top left corner
        canvas.drawLine(pos.x, pos.y, pos.x + lineWidth, pos.y, paint);
        canvas.drawLine(pos.x, pos.y, pos.x, pos.y + lineHeight, paint);
        // Top right corner
        canvas.drawLine(pos.x + size.width, pos.y, pos.x + size.width - lineWidth, pos.y, paint);
        canvas.drawLine(pos.x + size.width, pos.y, pos.x + size.width, pos.y + lineHeight, paint);
        // Bottom left corner
        canvas.drawLine(pos.x, pos.y + size.height, pos.x + lineWidth, pos.y + size.height, paint);
        canvas.drawLine(pos.x, pos.y + size.height, pos.x, pos.y + size.height - lineHeight, paint);
        // Bottom right corner
        canvas.drawLine(pos.x + size.width, pos.y + size.height, pos.x + size.width - lineWidth, pos.y + size.height, paint);
        canvas.drawLine(pos.x + size.width, pos.y + size.height, pos.x + size.width, pos.y + size.height - lineHeight, paint);
    }

    public static void drawDraggedObject(Canvas canvas, Bitmap image, ScreenPoint dragPoint) {
        if (image != null) {
            Rect orgRect = new Rect(0, 0, image.getWidth(), image.getHeight());
            Rect transformRect = new Rect(
                    dragPoint.x - image.getWidth() / 3,
                    dragPoint.y - image.getHeight() / 3,
                    dragPoint.x + image.getWidth() / 3,
                    dragPoint.y + image.getHeight() / 3);
            canvas.drawBitmap(image, orgRect, transformRect, Paints.IMAGE_TRANSLUCENT);
        }
    }

    public static void drawWire(Canvas canvas, Component start, Component dest) {
        LocalPoint startPos = start.getOutputPos();
        LocalPoint endPos = dest.getInputPosFor(start);
        canvas.drawLine(startPos.x - 1, startPos.y - 1, endPos.x - 1, endPos.y - 1, Paints.WIRE);
    }

}
