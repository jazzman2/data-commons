package sk.jazzman.data.domain;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Try<T> {


    static <T> Try success(T value) {
        return new Success(value);
    }

    static Try failed(Throwable throwable) {
        return new Failed(throwable);
    }

    Optional<T> get();


    Optional<Throwable> getThrowable();

    boolean isSuccess();

    boolean isFailed();

    default Try<T> onSuccess(Consumer<T> consumeData) {
        if (isSuccess()) {
            consumeData.accept(get().get());
        }

        return this;
    }

    default Try<T> onError(Consumer<Throwable> throwableConsumer) {
        if (isFailed()) {
            throwableConsumer.accept(getThrowable().get());
        }

        return this;
    }

    default  <TO> Try<TO> map(Function<T, TO> convert) {
        Try<TO> retVal;
        if (isSuccess()) {
            retVal = success(convert.apply(get().get()));
        } else {
            retVal = failed(getThrowable().get());
        }

        return retVal;
    }

    class Success<T> implements Try<T> {
        private final T value;

        protected Success(T value) {
            this.value = value;
        }

        @Override
        public Optional<T> get() {
            return Optional.ofNullable(value);
        }

        @Override
        public Optional<Throwable> getThrowable() {
            return Optional.empty();
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public boolean isFailed() {
            return false;
        }
    }

    class Failed<T> implements Try<T>{
        private final Throwable throwable;

        protected Failed(Throwable throwable) {
            this.throwable = throwable;
        }

        @Override
        public Optional<T> get() {
            return Optional.empty();
        }

        @Override
        public Optional<Throwable> getThrowable() {
            return Optional.ofNullable(throwable);
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public boolean isFailed() {
            return true;
        }
    }
}
