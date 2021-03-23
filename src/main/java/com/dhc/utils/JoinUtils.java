package com.dhc.utils;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @author haochen.dai
 * @Date: 2021-02-04 21:57
 * @Description:
 */
public class JoinUtils<E> {

    private Stream<E> objectStream;

    private List<Consumer> consumers;

    public JoinUtils<E> setMainObject(Collection<E> objects){
        this.objectStream = objects.stream();
        return this;
    }

    public JoinUtils<E> setObject(Consumer<? super E> consumer) {
        consumers.add(consumer);
        return this;
    }


}
