package mio68.lab.beanvalidation.compositeconstraint;

import lombok.Builder;

@Builder
public class Index {

    @ValidIndexName
    private String name;

}
