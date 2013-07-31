package de.codepitbull.wicket.springsecurity.page;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;

@SuppressWarnings("serial")
@AuthorizeInstantiation("ROLE_USER")
public class HomePage extends WebPage {

    public HomePage() {
        super();
    }

}
