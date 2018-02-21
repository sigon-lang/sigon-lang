package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Getter;

@Builder
public class Head {

    @Getter
    private ContextService context;

    @Getter
    private String clause;

}
