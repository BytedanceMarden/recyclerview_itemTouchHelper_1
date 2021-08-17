package com.bytedance.day20210817_demo5;

public interface ItemTouchAdapter {

    public void onItemSwiped(int position);

    public void onItemDragged(int from,int to);
}
