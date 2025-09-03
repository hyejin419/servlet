package com.example.jtsdemo;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.WKTWriter;

public class JTSDemo {
    public static void main(String[] args) {
        GeometryFactory factory = new GeometryFactory();
        Point station = factory.createPoint(new Coordinate(127.0123, 37.5200));
        LineString route = factory.createLineString(new Coordinate[] {
                new Coordinate(127.0100, 37.5250),
                new Coordinate(127.0300, 37.5000)
        });

        Geometry buffer = route.buffer(0.009);
        boolean inside = buffer.contains(station);

        System.out.println("1km 이내 충전소인가? " + inside);
    }
}
