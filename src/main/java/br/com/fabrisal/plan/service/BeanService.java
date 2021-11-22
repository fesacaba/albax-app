package br.com.fabrisal.plan.service;

import br.com.fabrisal.plan.exception.NotExistsImplamentationExecption;

public interface BeanService<T> {

    T getBean(String nome) throws NotExistsImplamentationExecption;
}
