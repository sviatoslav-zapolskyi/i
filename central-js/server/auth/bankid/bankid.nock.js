var nock = require('nock')
  , url = require('url')
  , urlencode = require('urlencode')
  , appUtil = require('../../app.util.spec')
  , bankidData = require('./bankid.data.spec')
  , bankidUtil = require('./bankid.util');

var headers = {
  'content-type': 'application/json;charset=UTF-8'
};

var baseUrls = bankidUtil.getBaseURLs();

var bankidMock = nock(baseUrls.access.base)
  .persist()
  .log(console.log)
  .get(baseUrls.access.path.auth)
  .query(true)
  .reply(302, {}, {
    'Location': function (req) {
      var query = appUtil.queryStringToObject(req.path);
      var redirect = urlencode.decode(query.redirect_uri);
      var baseURL = appUtil.pathFromURL(redirect);
      var redirectQuery = appUtil.queryStringToObject(redirect);
      var result = baseURL + '?link=' + urlencode.encode(redirectQuery.link) + '&code=112233';
      var path = url.parse(result).path;
      return 'http://localhost:9000' + path;
    }
  });

function createCustomerData(customer) {
  return {
    state: 'ok',
    customer: customer
  };
}

bankidMock
  .post(baseUrls.access.path.token, function (body) {
    return body && body.code === bankidData.codes.forCustomerDataResponse;
  })
  .reply(200, bankidData.createToken(bankidData.accessTokens.forCustomerDataResponse), headers)
  .post(baseUrls.resource.path.info)
  .matchHeader('Authorization', function (val) {
    return appUtil.extractAccessTokenBankID(val) === bankidData.accessTokens.forCustomerDataResponse;
  })
  .reply(200, createCustomerData(bankidData.customer), headers);
