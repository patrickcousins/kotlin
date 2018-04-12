/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package kotlin.jvm.functions

/** A function that takes N >= 23 arguments. */
// TODO: @SinceKotlin("1.3")
public interface FunctionN<out R> : Function<R> {
    /** Invokes the function with the specified arguments. */
    public operator fun invoke(vararg arg: Any?): R

    /** Returns the number of arguments that must be passed to this function. */
    // TODO: make a val?
    public fun getArity(): Int
}
