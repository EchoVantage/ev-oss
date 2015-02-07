/**
 * Copyright (C) 2014 EchoVantage (info@echovantage.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.echovantage.expression;

import org.echovantage.wonton.Wonton;

/**
 * Created by fuwjax on 2/3/15.
 */
public class TernaryExpression implements Expression {
    private final Expression test;
    private final Expression ifTrue;
    private final Expression ifFalse;

    public TernaryExpression(Expression test, Expression ifTrue, Expression ifFalse){
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public Object apply(Wonton o) {
        return test.evalBoolean(o) ? ifTrue.apply(o) : ifFalse.apply(o);
    }
}
