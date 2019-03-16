var webpack = require('webpack');
module.exports ={
    entry: './src/main.js',
    output:{
        path: __dirname,
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use:{
                    loader: 'babel-loader',
                }
            }
        ],
    },
    plugins: [
        new webpack.ProvidePlugin({
           $: "jquery",
           jQuery: "jquery"
       })
    ],
};