package com.nx.dao;

import com.nx.pojo.CarData;
import com.nx.utils.StrUtil;

import java.util.ArrayList;
import java.util.List;

public class CarDataDaoImpl implements CarDataDao {
    @Override
    public List<CarData> getCarDataList() {
        List<CarData> list = new ArrayList<>();
        List<Float> front = StrUtil.getInfo(StrUtil.FRONT);
        List<Float> left = StrUtil.getInfo(StrUtil.LEFT);
        List<Float> right = StrUtil.getInfo(StrUtil.RIGHT);
        List<Float> time = StrUtil.getInfo(StrUtil.TIME);
        for (int i = 0; i < front.size(); i++) {
            CarData carData = new CarData();
            carData.setDistanceFront(front.get(i));
            carData.setDistanceLeft(left.get(i));
            carData.setDistanceRight(right.get(i));
            if (time.size() > i) {
                carData.setTime(time.get(i));
            }
            list.add(carData);
        }
        return list;
    }
}
