package dev.sangain.library.model

public sealed class Status {
    public object Available : Status()
    public object Unavailable : Status()
    public object Losing : Status()
    public object Lost : Status()
}