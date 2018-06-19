package sk.jazzman.data.domain;

import java.util.function.Function;

public interface Result<D> extends Try<D> {

    Long getDuration();

    default  <TO> Result<TO> map(Function<D, TO> convert) {
        Result<TO> retVal;
        if (isSuccess()) {
            retVal = success(convert.apply(get().get()), getDuration());
        } else {
            retVal = failed(getThrowable().get(), getDuration());
        }

        return retVal;
    }

    static <R> Result<R> failed(Throwable throwable, Long duration) {
        return (Result<R>) new Failed<>(throwable, duration);
    }

    static <R> Result<R> success(R data, Long duration) {
        return new Success<>(data, duration);
    }

    class Success<T> extends Try.Success<T> implements Result<T>{
        private final Long duration;

        private Success(T value,Long duration) {
            super(value);
            this.duration = duration;
        }

        @Override
        public Long getDuration() {
            return duration;
        }
    }

    class Failed<T> extends Try.Failed<T> implements Result<T>{
        private final Long duration;

        private Failed(Throwable throwable,Long duration) {
            super(throwable);
            this.duration = duration;
        }

        @Override
        public Long getDuration() {
            return duration;
        }
    }
}
