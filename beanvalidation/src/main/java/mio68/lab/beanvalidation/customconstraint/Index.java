package mio68.lab.beanvalidation.customconstraint;

import lombok.Builder;

@Builder
public class Index {

    @ValidIndexName
    private String name;

}
