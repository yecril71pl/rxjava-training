package com.syncron;

import com.syncron.mim.MIMMapper;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

@Component
public class RxTrainingService {

    private static final Logger logger = LoggerFactory.getLogger(RxTrainingService.class);

    @Autowired
    APIService apiService;

    @Autowired
    MIMMapper mapper;

    @Autowired
    ReactiveFileWriter fileWriter;

    @Autowired
    ProcessingService processingService;

    /**
     * Should return Observable with non-discontinued products
     * <p>
     * Operators:
     * - filter
     * <p>
     * Utils:
     * - apiService.getProducts()
     */
    Observable<Product> getProducts() {
        return null;
    }

    /**
     * Should return Observable with order details for provided products.
     * Should send requests in parallel
     * <p>
     * Operators:
     * - map
     * - flatMap
     * <p>
     * Utils:
     * - apiService.getOrderDetails
     */
    Observable<OrderDetail> getOrderDetails(Observable<Product> products) {
        return null;
    }

    /**
     * Should return Maybe with order
     * Should return empty Maybe when 404 error happened
     * Should return pass any other error
     * <p>
     * Operators:
     * - onErrorComplete
     * <p>
     * Utils:
     * - apiService.getOrder
     */
    Maybe<Order> getOrder(long orderId) {
        return null;
    }

    /**
     * Should fetch products
     * Should fetch order details for products
     * Should fetch orders for order details
     * Should map ({@link Product}) -> ({@link com.syncron.mim.MIMItem}
     * Should map ({@link Order}, {@link OrderDetail}) -> ({@link com.syncron.mim.MIMOrder})
     * Should fetch products only once
     * <p>
     * Operators:
     * - map
     * - flatMapMaybe
     * - publish
     * - autoConnect
     * - as
     * - mergeArray
     * <p>
     * Utils:
     * - mapper
     * - fileWriter.file
     */
    Completable downloadAll(Path itemsDest, Path ordersDest) {
        return null;
    }

    /**
     * Should collect orders from live stream
     * Should start processing on collected orders every two seconds
     * Processing takes one second
     * Operators:
     * - buffer
     * - subscribe
     * Utils:
     * - apiService.observeOrders
     */
    Disposable processOrdersLive() {
        return null;
    }
}
