import { ShopsPage } from './app.po';

describe('shops App', function() {
  let page: ShopsPage;

  beforeEach(() => {
    page = new ShopsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
