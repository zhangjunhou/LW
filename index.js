import { PropTypes } from 'react';
import { requireNativeComponent, View } from 'react-native';

var LWebView = {
  name: 'LWebView',
  propTypes: {
    url: PropTypes.string,
    initscale: PropTypes.number,
    ...View.propTypes // 包含默认的View的属性
  },
};

module.exports = requireNativeComponent('LWebView', LWebView);