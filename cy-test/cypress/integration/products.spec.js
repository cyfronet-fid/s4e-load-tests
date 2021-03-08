/// <reference types="cypress" />

context('Actions', () => {
    it("test", () => {
        cy.visit('https://sok.docker-fid.grid.cyf-kr.edu.pl/map/products');

        cy.server()
        cy.route('GET', '/api/v1/products/*').as('turnOnProduct');
        cy.route('GET', `/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image/png&TRANSPARENT=true&*`)
            .as('mapTail');
        cy.get('[data-e2e="product-list"] [data-e2e="products__item"] [data-e2e="picker-item-label"]')
            .each((element, index) => {
                cy.get('[data-e2e="product-list"] [data-e2e="products__item"] [data-e2e="picker-item-label"]')
                    .eq(index)
                    .click();
                cy.wait('@turnOnProduct');
                cy.get('.products__visibility__spinner')
                    .should('not.exist');
                cy.wait('@mapTail')
                    .wait(2000);
                cy.get('[data-e2e="product-list"] [data-e2e="products__item"]')
                    .eq(index)
                    .should('have.class', 'active');
                cy.get('body').then($body => {
                    if ($body.find('.timeline__item--noproduct').length > 0) {
                        cy.get('.timeline__item--noproduct a').click();
                        cy.wait('@mapTail')
                            .wait(2000);
                    }

                    if ($body.find('.cookies button').length > 0) {
                        cy.get('.cookies button').click();
                    }

                    if ($body.find('[data-e2e="close-product-description-btn"]').length > 0) {
                        cy.get('[data-e2e="close-product-description-btn"]').click();
                    }
                });
            });
    })
})
